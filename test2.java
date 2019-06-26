import java.util.*;
public class Trangle {
	static double a,b,c;
	public Trangle()
	{
		
	}
	 public double getCircle()
	 {
		 return a+b+c;
	 }
	 public double getArea()
	 {
		 double p=(a+b+c)/2.0;
		 double s=Math.sqrt(p*(p-a)*(p-b)*(p-c));
		 return s;
	 }
	public static void main(String args[])
	{
		Trangle S=new Trangle();
		for(int i=0;i<1;){
			System.out.println("输入三角形三边长：");
			Scanner scan=new Scanner(System.in);
			a=scan.nextDouble();
			b=scan.nextDouble();
			c=scan.nextDouble();
			if(a+b<=c||a+c<=b||b+c<=a)
			{
				System.out.println("不能构成三角形！请重新输入！");
			}
			else{
				System.out.println("周长为："+S.getCircle());
				System.out.println("面积为："+S.getArea());
				i++;
			}
		}
	}
