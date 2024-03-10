package com.weixf.node;

public class GenericLinkedList<E> {

    //  节点值
    public String value;

    //  下一节点的指针
    public GenericLinkedList<E> next;

    public GenericLinkedList() {
    }

    public GenericLinkedList(String value) {
        this.value = value;
        this.next = null;
    }

}
