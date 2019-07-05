/**
 * 工程：sdframework
 * 文件：framework.sd.util.BigDecimalUtil.java
 */
package com.dy.cache.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 类名：BigDecimalUtil
 * 概要：BigDecimal计算工具
 *
 * @version 1.00 ( 2016年6月2日 )
 * @author yanjinyin
 *
 */
public class BigDecimalUtil {

    /**
     * Zero
     */
    public static final BigDecimal BD_0 = new BigDecimal(0);
    /**
     * 100
     */
    public static final BigDecimal BD_100 = new BigDecimal(100);

    /**
     * 先进行NULL检测后再进行加法计算
     *
     * @param bdRes
     *            被加数
     * @param bdAdd
     *            加数
     * @return 和
     */
    public static BigDecimal calAdd(BigDecimal bdRes, BigDecimal bdAdd)
    {
        // NULL检测
        if (bdAdd == null) {
            return bdRes;
        }
        if (bdRes == null) {
            return bdAdd;
        } else {
            // 加法计算
            return bdRes.add(bdAdd);
        }
    }

    /**
     * 先进行NULL检测后再进行减法计算
     *
     * @param bdRes
     *            被减数
     * @param bdSubtrahend
     *            减数
     * @return 差
     */
    public static BigDecimal calSubtract(BigDecimal bdRes, BigDecimal bdSubtrahend)
    {
        // NULL检测
        if (bdSubtrahend == null) {
            return bdRes;
        }
        if (bdRes == null) {
            return bdSubtrahend.negate();
        } else {
            // 减法计算
            return bdRes.subtract(bdSubtrahend);
        }
    }

    /**
     * 先进行NULL检测后再进行乘法计算
     *
     * @param bdRes
     *            被乘数
     * @param iMultiplier
     *            乘数
     * @return 积
     */
    public static BigDecimal calMultiply(BigDecimal bdRes, Integer iMultiplier)
    {
        if (iMultiplier == null) {
            return null;
        }
        return calMultiply(bdRes, new BigDecimal(iMultiplier), 2, RoundingMode.HALF_UP);
    }

    /**
     * 先进行NULL检测后再进行乘法计算
     *
     * @param bdRes
     *            被乘数
     * @param iMultiplier
     *            乘数
     * @param scale
     *            积精度
     * @param roundingMode
     *            积取舍模式
     * @return 积
     */
    public static BigDecimal calMultiply(BigDecimal bdRes, Integer iMultiplier, int scale, RoundingMode roundingMode)
    {
        // NULL检测
        if (iMultiplier == null) {
            return null;
        }
        return calMultiply(bdRes, new BigDecimal(iMultiplier), scale, roundingMode);
    }

    /**
     * 先进行NULL检测后再进行乘法计算
     *
     * @param bdRes
     *            被乘数
     * @param lMultiplier
     *            乘数
     * @return 积
     */
    public static BigDecimal calMultiply(BigDecimal bdRes, Long lMultiplier)
    {
        if (lMultiplier == null) {
            return null;
        }
        return calMultiply(bdRes, new BigDecimal(lMultiplier), 2, RoundingMode.HALF_UP);
    }

    /**
     * 先进行NULL检测后再进行乘法计算
     *
     * @param bdRes
     *            被乘数
     * @param lMultiplier
     *            乘数
     * @param scale
     *            积精度
     * @param roundingMode
     *            积取舍模式
     * @return 积
     */
    public static BigDecimal calMultiply(BigDecimal bdRes, Long lMultiplier, int scale, RoundingMode roundingMode)
    {
        // NULL检测
        if (lMultiplier == null) {
            return null;
        }
        return calMultiply(bdRes, new BigDecimal(lMultiplier), scale, roundingMode);
    }

    /**
     * 先进行NULL检测后再进行乘法计算
     *
     * @param bdRes
     *            被乘数
     * @param fMultiplier
     *            乘数
     * @return 积
     */
    public static BigDecimal calMultiply(BigDecimal bdRes, Float fMultiplier)
    {
        if (fMultiplier == null) {
            return null;
        }
        return calMultiply(bdRes, new BigDecimal(fMultiplier), 2, RoundingMode.HALF_UP);
    }

    /**
     * 先进行NULL检测后再进行乘法计算
     *
     * @param bdRes
     *            被乘数
     * @param fMultiplier
     *            乘数
     * @param scale
     *            积精度
     * @param roundingMode
     *            积取舍模式
     * @return 积
     */
    public static BigDecimal calMultiply(BigDecimal bdRes, Float fMultiplier, int scale, RoundingMode roundingMode)
    {
        // NULL检测
        if (fMultiplier == null) {
            return null;
        }
        return calMultiply(bdRes, new BigDecimal(fMultiplier), scale, roundingMode);
    }

    /**
     * 先进行NULL检测后再进行乘法计算
     *
     * @param bdRes
     *            被乘数
     * @param dMultiplier
     *            乘数
     * @return 积
     */
    public static BigDecimal calMultiply(BigDecimal bdRes, Double dMultiplier)
    {
        if (dMultiplier == null) {
            return null;
        }
        return calMultiply(bdRes, new BigDecimal(dMultiplier), 2, RoundingMode.HALF_UP);
    }

    /**
     * 先进行NULL检测后再进行乘法计算
     *
     * @param bdRes
     *            被乘数
     * @param dMultiplier
     *            乘数
     * @param scale
     *            积精度
     * @param roundingMode
     *            积取舍模式
     * @return 积
     */
    public static BigDecimal calMultiply(BigDecimal bdRes, Double dMultiplier, int scale, RoundingMode roundingMode)
    {
        // NULL检测
        if (dMultiplier == null) {
            return null;
        }
        return calMultiply(bdRes, new BigDecimal(dMultiplier), scale, roundingMode);
    }

    /**
     * 先进行NULL检测后再进行乘法计算
     *
     * @param bdRes
     *            被乘数
     * @param bdMultiplier
     *            乘数
     * @return 积
     */
    public static BigDecimal calMultiply(BigDecimal bdRes, BigDecimal bdMultiplier)
    {
        return calMultiply(bdRes, bdMultiplier, 2, RoundingMode.HALF_UP);
    }

    /**
     * 先进行NULL检测后再进行乘法计算
     *
     * @param bdRes
     *            被乘数
     * @param bdMultiplier
     *            乘数
     * @param scale
     *            积精度
     * @param roundingMode
     *            积取舍模式
     * @return 积
     */
    public static BigDecimal calMultiply(BigDecimal bdRes, BigDecimal bdMultiplier, int scale, RoundingMode roundingMode)
    {
        // NULL检测
        if (bdMultiplier == null) {
            return null;
        }
        if (bdRes == null) {
            return null;
        } else {
            // 乘法计算
            BigDecimal result = bdRes.multiply(bdMultiplier);
            MathContext mc = new MathContext(getLongLength(result) + scale, roundingMode);
            return result.round(mc);
        }
    }

    /**
     * 先进行NULL检测后再进行除法计算
     * ＊默认 精度2 四舍五入
     *
     * @param bdRes
     *            被除数
     * @param bdDivisor
     *            除数
     * @return 商
     */
    public static BigDecimal calDivide(BigDecimal bdRes, BigDecimal bdDivisor)
    {
        return calDivide(bdRes, bdDivisor, 2, RoundingMode.HALF_UP);
    }
    
    public static BigDecimal calDivide(BigDecimal bdRes, BigDecimal bdDivisor,int scale)
    {
        return calDivide(bdRes, bdDivisor, scale, RoundingMode.HALF_UP);
    }

    /**
     * 先进行NULL检测后再进行除法计算
     *
     * @param bdRes
     *            被除数
     * @param bdDivisor
     *            除数
     * @param scale
     *            商精度
     * @param roundingMode
     *            商取舍模式
     * @return 商
     */
    public static BigDecimal calDivide(BigDecimal bdRes, BigDecimal bdDivisor, int scale, RoundingMode roundingMode)
    {
        // NULL/Zero检测
        if (bdDivisor == null || compareTo(bdDivisor, BD_0) == 0) {
            return null;
        }
        if (bdRes == null) {
            return null;
        } else {
            // 除法计算
            return bdRes.divide(bdDivisor, scale, roundingMode);
        }
    }

    /**
     * 计算百分比
     *
     * @param bdRes
     *            被计算数
     * @return 百分比
     */
    public static BigDecimal calPercentage(BigDecimal bdRes)
    {
        return calDivide(bdRes, BD_100);
    }

    /**
     * 计算百分比
     *
     * @param bdRes
     *            被计算数
     * @param scale
     *            商精度
     * @param roundingMode
     *            商取舍模式
     * @return 百分比
     */
    public static BigDecimal calPercentage(BigDecimal bdRes, int scale, RoundingMode roundingMode)
    {
        return calDivide(bdRes, BD_100, scale, roundingMode);
    }

    /**
     * 比较大小
     *
     * @param bd1
     *            比较数1
     * @param bd2
     *            比较数2
     * @return 结果 -1：小于 0：等于 1：大于
     */
    public static int compareTo(BigDecimal bd1, BigDecimal bd2)
    {
        if (bd1 == null && bd2 == null)
            return 0;
        if (bd1 == null)
            return -1;
        if (bd2 == null)
            return 1;
        return bd1.compareTo(bd2);
    }

    /**
     * 获取整数位数
     *
     * @param numericalValue
     *            数值
     * @return
     */
    public static int getLongLength(BigDecimal numericalValue)
    {

        String sNumericalValue = numericalValue.toPlainString();
        String[] arrayValues = { "", "" };

        if (!(sNumericalValue.indexOf(".") < 0)) {
            arrayValues = sNumericalValue.split("\\.");
        } else {
            arrayValues[0] = sNumericalValue;
        }

        if (arrayValues[0].contains("-")) {
            arrayValues[0] = arrayValues[0].replaceAll("-", "");
        }

        int intLength = arrayValues[0].length();

        return intLength;

    }
    
    /**
     * 50%转换成50
     */
    public static BigDecimal exchangeStringToBigDecimal(String target) {
		if (!StringUtils.isBlank(target) && target.contains("%")) {
			target = target.replaceAll("%", "");
			Float f = Float.valueOf(target);
			return new BigDecimal(f);
		}
		return null;
	}
	
    /**
     * 50%转换成0.5
     */
	public static Double exchangeStringToDouble(String target) {
		if (!StringUtils.isBlank(target) && target.contains("%")) {
			target = target.replaceAll("%", "");
			Double b = Double.valueOf(target)/100;
			return b;
		}
		return null;
	}

}
