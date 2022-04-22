package com.proteus.la;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

	private  static final Logger logger = LoggerFactory.getLogger(Utils.class);
  public static   Long circularRightShift(Long v, Long k) {
		if(k == 0L) return v;
		return (v >>> (k%64)) | (v << (64 - (k%64)));
	}

	public static  Long circularLeftShift(Long v, Long k) {
		if(k == 0L) return v;
		return (v << (k%64)) | (v >>> (64 - (k%64)));
	}

	public static Long getMask(Long endIndex, Long startIndex){
		Long arg1 = -1L;
		Long arg2 = -1L;
		if(endIndex < 63)
		{
				arg1 = (1L << (endIndex + 1)) -1;
		}
		arg2 = arg2<<startIndex;
		logger.info("Mask["+endIndex+":"+startIndex+"]="+Long.toBinaryString(~(arg1 & arg2)));
		return ~(arg1 & arg2);
	}

	/*
	*	 x[63:32]
	* nibbleSize is occupied size.
	* calculate the mask for nibbleindex*4 + size -1
	*/
	public static  Long getNibbleMask(Long nibbleIndex, Long nibbleSize){
		Long startIndex = nibbleIndex*4 + nibbleSize;
		Long endIndex = nibbleIndex*4 + 4 - 1;
		return getMask(endIndex, startIndex);
	}
  
}
