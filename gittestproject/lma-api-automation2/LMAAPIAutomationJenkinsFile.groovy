pipeline{
	agent {
		node {
			label 'test-000-jenkinsslave-001'
		}
	}

	environment {
		project = 'lma-api-automation'
		targetDir = 'lma_mobile_report'
	}

	options {
		disableConcurrentBuilds()
	}

	stages{

		stage('lma api tests')
		{
			
			
			steps{
				script{
					try
					{
						def testEnv = params.testEnv
						def cucumberTags = params.cucumberTags
						def cucumberFeature = params.cucumberFeature

						def workspace = pwd()
						println "Workspace: " +workspace
							if(!isUnix())
							{
								println("Triggering build on Windows Slave")
								println("Current Workspace:"+pwd())
								if(cucumberTags!=null)
								{
									bat 'gradlew.bat LmaHybrisApiTest -PtestEnv=\"'+testEnv+'\" -PcucumberTags=\"' + cucumberTags + '\"'
								}
								else
								{
									bat 'gradlew.bat LmaHybrisApiTest -PtestEnv=\"'+testEnv+'\"'
								}

							}
							else
							{
								println("Triggering build on Linux Slave")
								if(cucumberTags!=null)
								{
									sh 'gradlew LmaHybrisApiTest -PtestEnv=\"'+testEnv+'\" -PcucumberTags=\"' + cucumberTags + '\"'
								}
								else
								{
									sh 'gradlew LmaHybrisApiTest -PtestEnv=\"'+testEnv+'\"'
								}
							}
						

					}catch(Exception ex)
					{
						println("Exception Hybris API Pipeline job for test Execution job pipeline script  : "+ex.getMessage())
						if(!isUnix())
							sh 'exit 1'
						else
							bat 'exit 1'
					}
				}
			}
		}



	}

	post {
		
		
		always {
			echo "Finishing up job with mail"
			
			script{
			
				def emailHTML = "<body>Hello,<br><br> Execution of the Hybris API Automation Suite for Headless is completed and please find below the execution results</br>"+
				"<style>table, th, td { border: 1px solid black; background-color: #f1f1c1;}th{background-color: #A3f1c1;}th, td {padding: 10px;text-align: center;}"+
				"</style><br><br><table style=\"width:50%\"><tr><th>Item</th><th>Details</th></tr><tr><td>Project</td><td>${currentBuild.fullDisplayName}</td>"+
				"</tr><tr><td>Environment</td><td>${params.testEnv}</td></tr><tr><td>Execution Status</td><td>${currentBuild.currentResult}</td>"+
				"</tr><tr><td>Build URL</td><td>${env.JOB_URL}</td></tr></table><br>Thanks</br><br>Headless QA Team</br></br></body>"
				
			emailext(
					body: emailHTML,
					mimeType: 'text/html',
					attachmentsPattern: 'REPORTS/cucumber-reports/*.htm',
					//recipientProviders: [[$class: 'RequesterRecipientProvider']],
					subject: "Reg: LMA API Tests Job - Build  ${currentBuild.currentResult} for ${params.testEnv}",
					to: 'anath2@levi.com, sganti@levi.com,ssaha3@levi.com'
					)
			
			}
			/*
			mail to: 'anath2@levi.com',
			mimeType: 'text/html',
			subject: "Reg: Hybris API Test - Build  ${currentBuild.currentResult} for ${params.testEnv}",
			//body: emailHTML
			body: "Somemail"
			*/
		}
	}


}
