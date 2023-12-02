class Cat extends Animal {
    private boolean isPersian;

    public Cat(String name, int age, boolean isPersian) {
        super(name, age);
        this.isPersian = isPersian;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " кот мяукает!");
    }

    public boolean isPersian() {
        return isPersian;
    }
}