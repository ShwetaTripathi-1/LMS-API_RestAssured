package resources;

import pojo.AddBatch;

public class TestData {

	public AddBatch addBatchPayload(String creationTime, String lastModTime, String batchName, String batchDescription, String batchNoOfClasses, String programId) {
		
		AddBatch b= new AddBatch();
		b.setCreationTime(creationTime);
		b.setLastModTime(lastModTime);
		b.setBatchName(batchName);
		b.setBatchNoOfClasses(batchNoOfClasses);
		b.setBatchDescription(batchDescription);
		b.setProgramId(programId);
		return b;
	}
}
