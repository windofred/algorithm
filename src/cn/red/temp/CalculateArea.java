package cn.red.temp;


/**
 * 
 * /******
	一、两圆相离、外切或至少有一圆半径为0：所求面积为0。
	二、两圆内切、内含：所求面积为小圆面积。
	三、两圆相交：这种情况分两种小情况：
	１、两圆心在公共弦的异侧，如图１所示；
	２、两圆心在公共弦的同侧如图２所示。先看图１，
	阴影部分可由公共弦AB分成两个弓形，求出两个弓形的面积相加即可，
	即S（阴影）　＝S（扇形O１AB）－S（三角形O１AB）＋S（扇形O２AB）－S（三角形O２AB）
	＝S（扇形O１AB）＋S（扇形O２AB）－S（四边形O１AO２B），
	即两扇形面积和与四边面积之差。再来看图２，
	这时所求面积为：S（扇形O１AB）－S（三角形O１AB）＋S
	（扇形O２AB<这里的扇形为圆心角为2*y的扇形>）+S（三角形O２AB）
	=S（扇形O１AB）＋S（扇形O２AB）－S（四边形O１AO２B），
	同样为两扇形面积和与四边面积之差。因此这两种小情况不必分开讨论。
	（图中a为圆心距，c为圆O1的半径，z为圆O2的半径，b为角AO1O2的大小，y为角AO2O1大小，
	A、B为公共弦的两端点，O1、O2为两圆的圆心）
 * 
 * @author sala
 *
 */

class Circle {
	double x,y;
    double r;
}


public class CalculateArea {

	public double calArea(Circle c1, Circle c2) {
		double d;
		double s, s1, s2, s3, angle1, angle2, temp;

		d = Math.sqrt((c1.x - c2.x) * (c1.x - c2.x) + (c1.y - c2.y) * (c1.y - c2.y));
		if (d >= (c1.r + c2.r))// 两圆相离
			return 0;
		if ((c1.r - c2.r) >= d)// 两圆内含,c1大
			return Math.acos(-1.0) * c2.r * c2.r;
		if ((c2.r - c1.r) >= d)// 两圆内含,c2大
			return Math.acos(-1.0) * c1.r * c1.r;

		angle1 = Math.acos((c1.r * c1.r + d * d - c2.r * c2.r) / (2 * c1.r * d));
		angle2 = Math.acos((c2.r * c2.r + d * d - c1.r * c1.r) / (2 * c2.r * d));

		s1 = angle1 * c1.r * c1.r;
		s2 = angle2 * c2.r * c2.r;
		s3 = c1.r * d * Math.sin(angle1);
		s = s1 + s2 - s3;

		return s;
	}

}
