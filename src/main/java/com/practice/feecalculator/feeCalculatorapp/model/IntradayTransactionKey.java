package com.practice.feecalculator.feeCalculatorapp.model;

import java.time.LocalDate;

import com.practice.feecalculator.feeCalculatorapp.utils.DateUtils;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class IntradayTransactionKey {
	private String clientId;
	private String securityId;
	private TransactionType transactionType;
	private LocalDate transactionDate;

	private IntradayTransactionKey(IntradayTransactionKeyBuilder builder) {
		this.clientId = builder.clientId;
		this.transactionType = builder.transactionType;
		this.transactionDate = builder.transactionDate;
		this.securityId = builder.securityId;
	}

	public static IntradayTransactionKeyBuilder builder() {
		return new IntradayTransactionKeyBuilder();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((securityId == null) ? 0 : securityId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntradayTransactionKey other = (IntradayTransactionKey) obj;
		if (clientId.equals(other.clientId)
				&& DateUtils.isEqual(transactionDate, other.transactionDate)
				&& (((transactionType == TransactionType.BUY || transactionType == TransactionType.SELL) 
				&& (other.transactionType == TransactionType.SELL || other.transactionType == TransactionType.BUY))
				&& (transactionType != other.transactionType))
				&& securityId.equals(other.securityId))
			return true;
		return false;
	}

	public static class IntradayTransactionKeyBuilder {
		private String clientId;
		private String securityId;
		private TransactionType transactionType;
		private LocalDate transactionDate;

		public IntradayTransactionKeyBuilder clientId(String clientId) {
			this.clientId = clientId;
			return this;
		}

		public IntradayTransactionKeyBuilder transactionType(TransactionType transactionType) {
			this.transactionType = transactionType;
			return this;
		}

		public IntradayTransactionKeyBuilder transactionDate(LocalDate transactionDate) {
			this.transactionDate = transactionDate;
			return this;
		}

		public IntradayTransactionKeyBuilder securityId(String securityId) {
			this.securityId = securityId;
			return this;
		}

		public IntradayTransactionKey build() {
			return new IntradayTransactionKey(this);
		}
	}
}
