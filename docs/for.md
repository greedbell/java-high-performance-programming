# For

## test1

```java
@Test
public void test1() {
    System.out.println("===== test1 =====");
    for (String item : getList()) {
        System.out.println(item);
    }
}

private List<String> getList() {
    System.out.println("get list");
    return Arrays.asList("a", "b", "c", "d");
}
```

打印日志

```text
===== test1 =====
get list
a
b
c
d
```

getList 只会被调用一次

## test2

```java
@Test
public void test2() {
    System.out.println("===== test2 =====");
    List<String > list = Arrays.asList("a", "b", "c", "d");
    for (int i = 0; i < getSize(list); i ++) {
        System.out.println(list.get(i));
    }
}

private int getSize(List list) {
    System.out.println("get size");
    return list.size();
}
```

打印日志

```text
===== test2 =====
get size
a
get size
b
get size
c
get size
d
get size
```

getSize 会被多次调用
