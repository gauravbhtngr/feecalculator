package com.practice.feecalculator.feeCalculatorapp.model;

import java.time.LocalDate;
import java.util.Comparator;

import com.practice.feecalculator.feeCalculatorapp.utils.DateUtils;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class GroupByKey implements Comparable<GroupByKey> {
	private String clientId;
	private TransactionType transactionType;
	private LocalDate transactionDate;
	private String priorityFlag;

	private GroupByKey(GroupByKeyBuilder builder) {
		this.clientId = builder.clientId;
		this.transactionType = builder.transactionType;
		this.transactionDate = builder.transactionDate;
		this.priorityFlag = builder.priorityFlag;
	}

	public static GroupByKeyBuilder builder() {
		return new GroupByKeyBuilder();
	}


	public String getClientId() {
		return clientId;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public String isPriorityFlag() {
		return priorityFlag;
	}

	@Override
	public int compareTo(GroupByKey o) {
		return Comparator.comparing(GroupByKey::getClientId)
				.thenComparing(GroupByKey::getTransactionDate)
				.thenComparing(GroupByKey::getTransactionType)
				.thenComparing(GroupByKey::isPriorityFlag)
				.compare(this, o);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId != null) ? 0 : clientId.hashCode());
		result = prime * result + ((transactionDate != null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((transactionType != null) ? 0 : transactionType.hashCode());
		result = prime * result + ((priorityFlag != null) ? 0 : priorityFlag.hashCode());
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
		GroupByKey other = (GroupByKey) obj;
		if (clientId.equals(other.clientId)
				&& transactionType == other.transactionType
				&& DateUtils.isEqual(transactionDate, other.transactionDate)
				&& priorityFlag.equals(other.priorityFlag))
			return true;
		return false;
	}

	public static class GroupByKeyBuilder {
		private String clientId;
		private TransactionType transactionType;
		private LocalDate transactionDate;
		private String priorityFlag;

		public GroupByKeyBuilder clientId(String clientId) {
			this.clientId = clientId;
			return this;
		}

		public GroupByKeyBuilder transactionType(TransactionType transactionType) {
			this.transactionType = transactionType;
			return this;
		}

		public GroupByKeyBuilder transactionDate(LocalDate transactionDate) {
			this.transactionDate = transactionDate;
			return this;
		}

		public GroupByKeyBuilder priorityFlag(String priorityFlag) {
			this.priorityFlag = priorityFlag;
			return this;
		}

		public GroupByKey build() {
			return new GroupByKey(this);
		}
	}
}
