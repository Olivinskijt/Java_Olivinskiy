module com.orders.model {
    requires static lombok;
    requires javafaker;
    requires java.sql;

    exports com.orders.model;
    exports com.orders.model.exceptions;
}