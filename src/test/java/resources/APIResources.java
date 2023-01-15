package resources;

public enum  APIResources {
	AddPBatchAPI("batches"),
	UpdateBatchByID("batches/{batchId}"),
	DeleteBatchByID("batches/{id}"),
	GetAllBatches("batches");
	private String resourse;
	
	APIResources(String resources){
		
		this.resourse= resourse;
		
	}

	public String getResourse()
	{
		return resourse;
	}

}
