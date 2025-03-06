public class VolvoFactory extends CarFactory<Volvo240> {
    public Volvo240 createCar(){
        return new Volvo240();
    }
}
