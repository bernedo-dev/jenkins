job('ejemplo2-job-DSL') {
  description('Job DSL de ejemplo para el curso de Jenkins')
  scm {
    git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node ->
      node / gitConfigName('rbernedo')
      node / gitConfigEmail('rufino.bernedo@gmail.com')
    }  
  }
  parameters {
    stringParam('nombre', defaultValue = 'Rufino', description = 'Parametro de cadena para el Job Booleano')
    choiceParam('planeta', ['Mercurio','Venus','Tierra','Marte','Jupiter','Saturno','Urano','Neptuno'])
    booleanParam('agente', false)
  }
  triggers {
   	cron('H/7 * * * *')
  }
  steps {
  	shell("bash jobscript.sh") 
  }
  publishers {
    mailer('rufino.bernedo@gmail.com', true, true)
  }
}
