class ParkingSystem {

    int park [] =new int [4];
    public ParkingSystem(int big, int medium, int small) {
        park[1]= big;
        park[2]=medium;
        park[3]= small;
        
    }
    
    public boolean addCar(int carType) {
        
        
        if(park[carType]==0)return false;

        park[carType]=park[carType]-1;
        
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */