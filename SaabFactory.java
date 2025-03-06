public class SaabFactory extends CarFactory<Saab95> {
    public Saab95 createCar(){
        return new Saab95();
    }
}
