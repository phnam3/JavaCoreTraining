public class Son extends Father {
    /***
     * No need to handle exception inside the subclass because before initialization,
     * no instance of Son (and Father) is created (constructor hasn't been called).
     * Therefore, the app should handle the exception during the initialization process (Main class)
     */
    public Son() {
        super();
    }

    public Son(boolean exception) throws Exception {
        super(exception);
    }
}
