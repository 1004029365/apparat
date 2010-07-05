package apparat.math {
	import apparat.inline.Macro;

	public class MathMacro extends Macro {

		/**
		 * Computes and returns the sine and the cosine of the specified angle in radians.
		 *
		 * To calculate a radian, see the overview of the Math class.
		 *
		 * This method is only a fast sine/cosine approximation.
		 *
		 * @param angleRadians A number that represents an angle measured in radians.
		 * @param sin Sine of value from -1.0 to 1.0.
		 * @param cos Cosine of value from -1.0 to 1.0.
		 */
		public static function sincos(angleRadians:Number, sin:Number, cos:Number):void {
			//http://pedersen.web.cern.ch/pedersen/project-leir-dsp-bc/matlab/fast_sine_cosine/fast_sine_cosine.doc

			var angleTmp:Number = angleRadians * 0.6366197723675814;

			var qi:int = int(angleTmp + 0.5 - Number(angleTmp < 0)); // round(angle)
			angleTmp -= qi; // x=frac

			var xq:Number = angleTmp * angleTmp;
			// less precision
			var f0:Number = 1.0 + xq * (xq * 0.25360671639164339 - 1.2336979844380824);
			var f1:Number = angleTmp * (1.5707963267948966 + xq * (  xq * 0.079679708649230657 - 0.64596348437163809));

			//more precision
			//			var f0:Number = 1.0 + xq * (xq * (0.25360671639164339 - 0.020427240364907607 * xq) - 1.2336979844380824);
			//			var f1:Number = angleTmp * (1.5707963267948966 + xq * (  xq * (0.079679708649230657 - 0.0046002309092153379 * xq) - 0.64596348437163809));

			var qi1:Number = qi & 1;
			var qi2:Number = qi & 2;
			var qi1_2:Number = 1.0 - qi2;
			qi2 = qi1 * qi1_2;
			qi1 = (1.0 - qi1) * qi1_2;

			cos = qi1 * f0 - qi2 * f1;
			sin = qi1 * f1 + qi2 * f0;
		}

		/**
		 * Computes and returns the sine and the cosine of the specified angle in radians.
		 * with more precision that the previous sincos
		 *
		 * To calculate a radian, see the overview of the Math class.
		 *
		 * This method is only a fast sine/cosine approximation.
		 *
		 * @param angleRadians A number that represents an angle measured in radians.
		 * @param sin Sine of value from -1.0 to 1.0.
		 * @param cos Cosine of value from -1.0 to 1.0.
		 */
		public static function sincos2(angleRadians:Number, sin:Number, cos:Number):void {
			//http://pedersen.web.cern.ch/pedersen/project-leir-dsp-bc/matlab/fast_sine_cosine/fast_sine_cosine.doc

			var angleTmp:Number = angleRadians * 0.6366197723675814;

			var qi:int = int(angleTmp + 0.5 - Number(angleTmp < 0)); // round(angle)
			angleTmp -= qi; // x=frac

			var xq:Number = angleTmp * angleTmp;
			// less precision
			//			var f0:Number = 1.0 + xq * (xq * 0.25360671639164339 - 1.2336979844380824);
			//			var f1:Number = angleTmp * (1.5707963267948966 + xq * (  xq * 0.079679708649230657 - 0.64596348437163809));

			//more precision
			var f0:Number = 1.0 + xq * (xq * (0.25360671639164339 - 0.020427240364907607 * xq) - 1.2336979844380824);
			var f1:Number = angleTmp * (1.5707963267948966 + xq * (  xq * (0.079679708649230657 - 0.0046002309092153379 * xq) - 0.64596348437163809));

			var qi1:Number = qi & 1;
			var qi2:Number = qi & 2;
			var qi1_2:Number = 1.0 - qi2;
			qi2 = qi1 * qi1_2;
			qi1 = (1.0 - qi1) * qi1_2;

			cos = qi1 * f0 - qi2 * f1;
			sin = qi1 * f1 + qi2 * f0;
		}
	}
}