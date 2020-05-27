public class C {

    public DBeanWithPrototypeScope injectDBeanWithPrototypeScope() {
        return null;
    }

    public DBeanWithPrototypeScope getDPrototype() {
        return injectDBeanWithPrototypeScope();
    }


}
