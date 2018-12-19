package com.example.demo.enm;

public enum EntityEnum {
	/**
	 * 集团系统重量
	 */
	GROUP_SYSTEM_WEIGHT("groupWeight","集团系统重量"),
	/**
	 * 集团费率
	 */
	GROUP_RATE("groupRate","集团费率"),
	/**
	 * 集团运费
	 */
	GROUP_FREIGHT("groupFreight","集团运费"),

	/**
	 * 应付金额
	 */
	PAY_AMOUNT("payAmount","应付金额"),
	/**
	 * 四率扣款金额
	 */
	DEDUCTION_SUM("deductionSum","四率扣款金额"),
	/**
	 * 落货扣款合计
	 */
	DEDUCTION("deduction","落货扣款合计"),
	/**
	 * 质控调整后金额
	 */
	ADJUST_AMOUNT("adjustAmount","质控调整后金额"),
	/**
	 * 货代ID
	 */
	FORWARDER_ID("forwarderId","货代ID"),
	/**
	 * 始发城市ID
	 */
	START_CITY_ID("startCityId","始发城市ID"),
	/**
	 * 目的城市ID
	 */
	END_CITY_ID("endCityId","目的城市ID"),
	/**
	 * 航班号
	 */
	FLIGHT_NO("flightNo","航班号"),
	/**
	 * 业务类型
	 */
	TASK_TYPE("taskType","业务类型"),
	/**
	 * 费率名称
	 * 1：运费费率；2：操作费费率；3：机场操作费（吨）
	 */
	PRICE_NAME("priceName","费率名称"),
	/**
	 *  结算类型
	 * 0：统价；1：阶梯价
	 */
	SETTLE_TYPE("settleType","结算类型"),
	/**
	 *  结算模式
	 * 0：最低收费；1：元/公斤
	 */
	SETTLE_MODE("settleMode","结算模式"),
	/**
	 * 费率配置ID
	 */
	RATE_CONFIG_ID("configId","费率配置ID"),
	/**
	 * 代理系统重量
	 */
	AGENT_SYSTEM_WEIGHT("agentWeight","代理系统重量"),
	/**
	 * 代理费率
	 */
	AGENT_RATE("agentRate","代理费率"),
	/**
	 * 代理运费
	 */
	AGENT_FREIGHT("agentFreight","代理运费"),
	/**
	 * 最低价
	 */
	MIN_RATE("minRate","最低价"),
	/**
	 * 费率
	 */
	RATE("rate","费率"),
	/**
	 * 运费
	 */
	FREIGHT("freight","运费"),
	/**
	 * 机场操作费费率
	 */
	AGENT_OPE_RATE("agentOpeRate","代理操作费费率"),
	/**
	 * 机场操作费
	 */
	AGENT_OPE_FEE("agentOpeFee","代理操作费"),
	/**
	 * 机场操作费费率
	 */
	AIR_OPE_RATE("airOpeRate","机场操作费费率"),
	/**
	 * 机场操作费
	 */
	AIR_OPE_FEE("airOpeFee","机场操作费"),
	/**
	 * 月汇总毛重
	 */
	SUM_ROUND_WEIGHT("sumRoundWeight","月汇总毛重"),
	/**
	 * 日均重量
	 */
	DAILY_AVG_WEIGHT("dailyAvgWeight","日均重量"),
	/**
	 * 系统重量
	 */
	SYSTEM_WEIGHT("weight","系统重量");
	
	
	EntityEnum(String code, String desc) {
		this.code = code;
		this.desc =desc;
	}
	
	private String code;
	private String desc;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
