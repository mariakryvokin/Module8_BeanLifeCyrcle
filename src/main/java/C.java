public class C {
    private DBeanWithPrototypeScope d;

    public DBeanWithPrototypeScope injectDBeanWithPrototypeScope() {
        return null;
    }

    public DBeanWithPrototypeScope getDPrototype() {
        this.d = injectDBeanWithPrototypeScope();
        return d;
    }


}
