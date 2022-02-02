# spring-react 연동

## 1. 스프링 프로젝트 생성

## 2. React 폴더 생성

## 3. React.js 프로젝트 생성

## 4. build.gradle에 데이터 추가 
```
def reactDir = "$projectDir/src/main/webapp/react프로젝트명";

sourceSets{
	main{
		resources{
			srcDirs = ["$projectDir/src/main/resources"]
		}
	}
}

processResources{
	dependsOn "copyReactBuildFiles"
}

task installReact(type:Exec){
	workingDir "$reactDir"
	inputs.dir "$reactDir"
	group = BasePlugin.BUILD_GROUP
	
	if(System.getProperty('os.name').toLowerCase(Locale.ROOT).contains('windows')){
		commandLine "npm.cmd", "audit", "fix"
		commandLine 'npm.cmd', 'install'
	}else{
		commandLine "npm", "audit", "fix"
		commandLine 'npm', 'install'
	}
}

task buildReact(type:Exec){
	dependsOn "installReact"
	workingDir "$reactDir"
	inputs.dir "$reactDir"
	group = BasePlugin.BUILD_GROUP
	
	if(System.getProperty('os.name').toLowerCase(Locale.ROOT).contains('windows')){
		commandLine "npm.cmd", "run-script", "build"
	}else{
		commandLine "npm", "run-script", "build"
	}
}

task copyReactBuildFiles(type:Copy){
	dependsOn "buildReact"
	from "$reactDir/build"
	into "$projectDir/src/main/resources/static"
}
```

## 5. 명령어 입력
```
./gradlew build 
```

## 6. 서버 실행 후 접속 http://localhost:8080