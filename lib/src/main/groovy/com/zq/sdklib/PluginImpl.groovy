package com.zq.sdklib

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.artifacts.ProjectDependency

public class PluginImpl implements Plugin<Project> {
    void apply(Project project) {

        println "ZaiQiang PluginImpl -------"
        //定义扩展属性
        //project.extensions返回ExtensionContainer对象，
        // project.extensions.create("Name", ExtensionClass)创建 extension,
        // 按后面的使用来看，创建extension后会将其加入到ExtensionContainer对象中
        ////创建扩展属性 ZQSDK，并将外部属性配置使用PluginExtension进行管理
        project.extensions.create('ZQSDK', PluginExtension, project)
        project.ZQSDK.extensions.create('Internal', InternalExtension)
        project.task('zqPrintTask', type: PrintTask)

        project.task('zqPrintDependencies') << {
            println "ZaiQiang Plugins=========="
            project.plugins.each {println " "+ it.toString()}
            println "Dependencies=========="

            project.configurations.each {
                println "$it.name:----------------------"
                it.getAllDependencies().each {
                    println "$it.group:$it.name:$it.version"
                }
            }

        }

        if(project.("ZQSDK")){
            println "ZQSDK--设置赋值前"
            println "ZQSDK "+project.ZQSDK.param1
            println "ZQSDK "+project.ZQSDK.param2
            println "ZQSDK "+project.ZQSDK.param3
        }
        //配置后的回调
        project.afterEvaluate {
            if(project.("ZQSDK")){
                println "ZQSDK--设置赋值后"
                println "ZQSDK "+project.ZQSDK.param1
                println "ZQSDK "+project.ZQSDK.param2
                println "ZQSDK "+project.ZQSDK.param3

                if(project.ZQSDK.testDomains){
                    project.ZQSDK.testDomains.all { data ->
                        println data
                    }
                }

                if(project.ZQSDK.baseLib){
                    println "baseLib版本$project.ZQSDK.baseLib.versionName"
                    project.dependencies.add("api",
                            "com.ziq.base:base:$project.ZQSDK.baseLib.versionName")
                }
                if(project.ZQSDK.customViewLib){
                    println "customViewLib版本$project.ZQSDK.customViewLib.versionName"
                    project.dependencies.add("api",
                            "com.zq.customviewlib:customviewlib:$project.ZQSDK.customViewLib.versionName")
                }
            }
        }
    }
}