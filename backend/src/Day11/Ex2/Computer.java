package Day11.Ex2;

public class Computer extends Calculator{
	@Override
	public double areaCircle(double r) {
		// TODO Auto-generated method stub
		System.out.println("자식 객체가 재정의");
		return Math.PI*r*r;
		
	}
}
