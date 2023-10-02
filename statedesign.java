interface TrafficState { // State interface

    void handle();
    
    }
    
    // Concrete State classes
    
    class RedLightState implements TrafficState {
    
    @Override
    
    public void handle() {
    
    System.out.println("Stop at the red light.");
    
    }
    
    }
    
    class GreenLightState implements TrafficState {
    
    @Override
    
    public void handle() {
    
    System.out.println("Go at the green light.");
    
    }
    
    }
    
    class YellowLightState implements TrafficState {
    
    @Override
    
    public void handle() {
    
    System.out.println("Slow down at the yellow light.");
    
    }
    
    }
    
    class TrafficSignal { // Context class
    
    private TrafficState currentState;
    
    public TrafficSignal() {
    
    currentState = new RedLightState();
    
    }
    
    public void setState(TrafficState state) {
    
    currentState = state;
    
    }
    
    public void handle() {
    
    currentState.handle();
    
    }
    
    }
    
    class TrafficControlSignal {
    
    public static void main(String[] args) {
    
    TrafficSignal trafficSignal = new TrafficSignal();
    
    // Simulate traffic signal changing states
    
    trafficSignal.setState(new GreenLightState());
    
    trafficSignal.handle();  	//Go at the green light.
    
    trafficSignal.setState(new YellowLightState());
    
    trafficSignal.handle(); 	//  Slow down at the yellow light.
    
    trafficSignal.setState(new RedLightState());
    
    trafficSignal.handle(); 	// Stop at the red light.
    
    }
    
    }