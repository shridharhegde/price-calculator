package price.calculator.service;

import java.util.List;

public interface IFileReaderService {
	public <T> List<T> readFileData(String filePath);
}
