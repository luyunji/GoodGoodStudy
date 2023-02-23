package org.example;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * 使用spring-i18n国际化支持，支持spring-validate校验和国际化消息
 * {@link /i18n/messages}使用多语言消息配置消息
 * spring有默认i18n的配置{@link /application.yml}
 * @author luyunji
 */
public class SpringI18n {

    static ThreadLocal<Locale> i18n = new ThreadLocal<>();

    private static final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

    public static void main(String[] args) {
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
        messageSource.setBasename("i18n/messages");
        i18n.set(Locale.US);
        String name = getMessage("name","luyunji");
    }

    public static String getMessage(String key, Object... objs) {
        return messageSource.getMessage(key, objs, i18n.get());
    }
}
