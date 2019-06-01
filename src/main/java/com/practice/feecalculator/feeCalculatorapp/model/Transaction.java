package com.practice.feecalculator.feeCalculatorapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class Transaction {
	private String externalTransactionId;
	private String clientId;
	private String securityId;
	private TransactionMode transactionMode;
	private TransactionType transactionType;
	private LocalDate transactionDate;
	private BigDecimal marketValue;
	private String priorityFlag;
	private BigDecimal processingFee;

	public IntradayTransactionKey intradayKey() {
		return IntradayTransactionKey.builder()
				.clientId(this.clientId)
				.securityId(this.securityId)
				.transactionDate(this.transactionDate)
				.transactionType(this.transactionType)
				.build();
	}
	
	public GroupByKey groupByKey() {
		return GroupByKey
				.builder()
				.clientId(this.clientId)
				.priorityFlag(this.priorityFlag)
				.transactionDate(this.transactionDate)
				.transactionType(this.transactionType)
				.build();
	}

	public String getExternalTransactionId() {
		return externalTransactionId;
	}

	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public TransactionMode getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(TransactionMode transactionMode) {
		this.transactionMode = transactionMode;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(BigDecimal marketValue) {
		this.marketValue = marketValue;
	}

	public String getPriorityFlag() {
		return priorityFlag;
	}

	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}

	public BigDecimal getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(BigDecimal processingFee) {
		this.processingFee = processingFee;
	}

	public boolean isHighPriority() {
		return this.priorityFlag == "Y" ? true : false;
	}
	
	public boolean isSell() {
		return this.transactionType == TransactionType.SELL;
	}
	
	public boolean isBuy() {
		return this.transactionType == TransactionType.BUY;
	}
	
	public boolean isWithdraw() {
		return this.transactionType == TransactionType.WITHDRAW;
	}
	
	public boolean isDeposit() {
		return this.transactionType == TransactionType.DEPOSIT;
	}
}
