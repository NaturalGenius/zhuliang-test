package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.example.demo.entity.Person;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * 参数化测试
 * 
 * @author MSI-PC
 *
 */
public class ParameterizedTestDemo {

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void palindromes(String candidate) {
        System.out.println(candidate);
        assertTrue(!StringUtils.isEmpty(candidate));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithValueSource(int argument) {
        assertNotNull(argument);
    }

    /**
     * @EnumSource能够很方便地提供Enum常量。该注解提供了一个可选的names参数，你可以用它来指定使用哪些常 量。如果省略了，就意味着所有的常量将被使用，就像下面的例子所示。
     * @param timeUnit
     */
    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void testWithEnumSource(TimeUnit timeUnit) {
        System.out.println(timeUnit.name());
        assertNotNull(timeUnit);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
    void testWithEnumSourceInclude(TimeUnit timeUnit) {
        assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
    }

    /**
     * @EnumSource注解还提供了一个可选的mode参数，它能够细粒度地控制哪些常量将会被传递到测试方法中。例如， 你可以从枚举常量池中排除一些名称或者指定正则表达式，如下面代码所示。 @param timeUnit
     */
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = Mode.EXCLUDE, names = {"DAYS", "HOURS"})
    void testWithEnumSourceExclude(TimeUnit timeUnit) {
        assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
        assertTrue(timeUnit.name().length() > 5);
    }

    /**
     * @MethodSource允许你引用测试类中的一个或多个工厂方法。这些工厂方法必须返回一个Stream、Iterable、 Iterator或者参数数组。另外，它们不能接收任何参数。默认情况下，它们必须是static方法，除非测试类使用了
     * @TestInstance(Lifecycle.PER_CLASS)注解。
     * 
     *                                       @param argument
     */
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithSimpleMethodSource(String argument) {
        System.out.println(argument);
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("foo", "bar");
    }

    @ParameterizedTest
    @MethodSource("personProvider")
    void testWithPersionMethodSource(Person person) {
        System.out.println(person.getName());
        assertNotNull(StringUtils.isEmpty(person.getName()));
    }

    static Stream<Person> personProvider() {
        return Stream.of(new Person("张三", 10), new Person("李四", 10));
    }

    /**
     * 如果测试方法声明了多个参数，则需要返回一个Arguments实例的集合或Stream，如下面代码所示。请注意， Arguments.of(Object ...)是Arguments接口中定义的静态工厂方法。
     * 
     * @param str
     * @param num
     * @param list
     */
    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        assertEquals(3, str.length());
        assertTrue(num >= 1 && num <= 2);
        assertEquals(2, list.size());
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(Arguments.of("foo", 1, Arrays.asList("a", "b")),
            Arguments.of("bar", 2, Arrays.asList("x", "y")));
    }

    /**
     * @CsvSource使用单引号'作为引用字符。请参考上述示例和下表中的'baz，qux'值。一个空的引用值''表示一个空 的String；而一个完全空的值被当成一个null引用。如果null引用的目标类型是基本类型，则会抛出一个
     *                                                              ArgumentConversionException。
     * @param first
     * @param second
     */
    @ParameterizedTest
    @CsvSource({"foo, 1", "bar, 2", "'baz, qux', 3"})
    void testWithCsvSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }

    /**
     * @CsvFileSource允许你使用类路径中的CSV文件。CSV文件中的每一行都会触发参数化测试的一次调用。 与@CsvSource中使用的语法相反，@CsvFileSource使用双引号"作为引号字符，请参考上面例子中的"baz，
     *                                                         qux"值，一个空的带引号的值""表示一个空String，一个完全为空的值被当成null引用，如果null引用的目标
     *                                                         类型是基本类型，则会抛出一个ArgumentConversionException。
     * @param first
     * @param second
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/two-column.csv")
    void testWithCsvFileSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }

    /**
     * @ArgumentsSource 可以用来指定一个自定义且能够复用的ArgumentsProvider。
     * 
     * @param argument
     */
    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    void testWithArgumentsSource(String argument) {
        assertNotNull(argument);
    }

    static class MyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of("foo", "bar").map(Arguments::of);
        }
    }
}
