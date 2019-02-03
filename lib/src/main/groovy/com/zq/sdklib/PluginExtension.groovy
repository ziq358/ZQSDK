import com.zq.sdklib.lib.BaseLibExtension
import com.zq.sdklib.lib.CustomViewLibExtension
import com.zq.sdklib.TestDomainType
import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.util.ConfigureUtil

public class PluginExtension {
    def param1 = "param1 defaut"
    def param2 = "param2 defaut"
    def param3 = "param3 defaut"
    def param4
    //定义一个 NamedDomainObjectContainer 属性
    NamedDomainObjectContainer<TestDomainType> testDomains

    PluginExtension(Project project) {
        NamedDomainObjectContainer<TestDomainType> domainObjs = project.container(TestDomainType)
        testDomains = domainObjs
    }
    //让其支持 Gradle DSL 语法
    void testDomain(Action<NamedDomainObjectContainer<TestDomainType>> action) {
        println("++call testDomain(Action<NamedDomainObjectContainer<TestDomainType>> action)")
        action.execute(testDomains)
    }


    BaseLibExtension baseLib
    CustomViewLibExtension customViewLib

    //创建内部Extension，名称为方法名 BaseLib
    void BaseLib(Action<BaseLibExtension> action) {
        println("++call BaseLib(Action<BaseLibExtension> action)")
        baseLib = new BaseLibExtension()
        action.execute(baseLib)
    }

    //创建内部Extension，名称为方法名 BaseLib
    void BaseLib(Closure c) {
        println("++call BaseLib(Closure c)")
        baseLib = new BaseLibExtension()
        ConfigureUtil.configure(c, baseLib)
    }

    void CustomViewLib(Action<CustomViewLibExtension> action) {
        println("++call CustomViewLib(Action<CustomViewLibExtension> action)")
        customViewLib = new CustomViewLibExtension()
        action.execute(customViewLib)
    }

    void CustomViewLib(Closure c) {
        println("++call CustomViewLib(Closure c)")
        customViewLib = new CustomViewLibExtension()
        ConfigureUtil.configure(c, customViewLib)
    }

}