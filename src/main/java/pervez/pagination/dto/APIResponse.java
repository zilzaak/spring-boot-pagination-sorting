package pervez.pagination.dto;

import pervez.pagination.entity.Product;

public class APIResponse<T> {

    int recordCount;
    T response;

	public APIResponse(int recordCount, T response) {
		super();
		this.recordCount = recordCount;
		this.response = response;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}

	public APIResponse(T response) {
		super();
		this.recordCount = 7;
		this.response = response;
	} 
    
}
