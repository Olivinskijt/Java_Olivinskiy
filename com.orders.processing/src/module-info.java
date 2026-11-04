module com.orders.processing {
    requires static lombok;
    requires transitive com.orders.model;

    exports com.orders.processing;
}