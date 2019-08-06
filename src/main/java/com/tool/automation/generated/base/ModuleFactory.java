
package com.tool.automation.generated.base;

import java.lang.reflect.Constructor;
import com.google.inject.Module;
import org.testng.IModuleFactory;
import org.testng.ITestContext;
import org.testng.internal.ClassHelper;

public class ModuleFactory
    implements IModuleFactory
{

    private Module module;
    private ITestContext iTestContext;
    private ClassHelper classHelper;
    private Constructor constructor;
    @Override
    public Module createModule(ITestContext context, Class<?> testClass) {
        String moduleClassName = System.getProperty("tool.kw.module.class");

        if (null != moduleClassName) {
            Class<Module> moduleClass;

            try {
                moduleClass = (Class<Module>) testClass.getClassLoader().loadClass(moduleClassName);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(String.format("Guice module class '%s' was not found.", moduleClassName));
            }

            try {
                Constructor<Module> moduleConstructor = moduleClass.getDeclaredConstructor(ITestContext.class);

                return ClassHelper.newInstance(moduleConstructor, context);
            } catch (NoSuchMethodException e) {
                return ClassHelper.newInstance(moduleClass);
            }
        } else {
            return null;
        }
    }
}
