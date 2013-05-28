package org.folder;

import android.os.Bundle;

public class FilePickerActivity extends FolderPickerActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setAcceptFiles(true);
		super.onCreate(savedInstanceState);
	}

}
