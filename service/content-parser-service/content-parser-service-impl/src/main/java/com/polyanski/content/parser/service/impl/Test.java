package com.polyanski.content.parser.service.impl;

import com.polyanski.content.parser.service.api.CommonParser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: vadym_polyanski
 * Date: 04.04.17
 * Time: 14:32
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.polyanski");
        context.refresh();

        CommonParser commonParser = (CommonParserImpl) context.getBean("commonParser");
//        commonParser.parse();
    }
}
