package com;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

import static javax.tools.Diagnostic.Kind.ERROR;

/**
 * Created by dengshengjin on 15/12/15.
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class AutoLayoutProcesser extends AbstractProcessor {
    private Messager mMessager;
    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mMessager = processingEnv.getMessager();
        filer = processingEnv.getFiler();
    }

    @Override
    public Set getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(StaticStringUtil.class.getCanonicalName());
        return types;
    }

    @Override
    public boolean process(Set annotations, RoundEnvironment roundEnv) {
        // Examine uses of annotations in the apps' abstract
        // syntax tree, and generate one or more resulting classes.
        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(whatsMyName("slimShady"))
                .addMethod(whatsMyName("eminem"))
                .addMethod(whatsMyName("marshallMathers"))
                .build();
        try {
            JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld).addFileComment("this class is for test")
                    .build();


            javaFile.writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private static MethodSpec whatsMyName(String name) {
        return MethodSpec.methodBuilder(name)
                .returns(String.class)
                .addStatement("return $S", name)
                .build();
    }

    private void error(String message, Object... args) {
        if (args.length > 0) {
            message = String.format(message, args);
        }
        mMessager.printMessage(ERROR, message);
    }
}