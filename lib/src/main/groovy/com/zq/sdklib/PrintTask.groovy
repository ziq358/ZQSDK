import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

public class PrintTask extends DefaultTask {

    @TaskAction
    void output() {
        println "param1 is ${project.ZQSDK}"
        println "param1 is ${project.ZQSDK.param1}"
        println "param2 is ${project.ZQSDK.param2}"
        println "param3 is ${project.ZQSDK.param3}"
        println "param4 is ${project.ZQSDK.param4}"
        println "nestparam1 is ${project.ZQSDK.Internal.nestParam1}"
        println "nestparam2 is ${project.ZQSDK.Internal.nestParam2}"
        println "nestparam3 is ${project.ZQSDK.Internal.nestParam3}"
    }
}
