package org.folder;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class FolderPickerTest extends Activity implements OnClickListener, DialogInterface.OnClickListener {
    private FolderPicker mFolderDialog;
    private FolderPicker mFileDialog;
	private View mPickFolder;
	private View mPickFile;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mPickFolder = findViewById(R.id.pick_folder);
        mPickFolder.setOnClickListener(this);
        mPickFile = findViewById(R.id.pick_file);
        mPickFile.setOnClickListener(this);
    }

	public void onClick(View v) {
		if (v == mPickFolder) {
			mFolderDialog = new FolderPicker(this, this, 0);
			mFolderDialog.show();
		}
		if (v == mPickFile) {
			mFileDialog = new FolderPicker(this, this, android.R.style.Theme, true);
			mFileDialog.show();
		}
	}

	public void onClick(DialogInterface dialog, int which) {
		if (dialog == mFolderDialog) {
			((TextView) findViewById(R.id.folder_path)).setText(mFolderDialog.getPath());
		}
		if (dialog == mFileDialog) {
			String path = mFileDialog.getPath();
			if (path == null) {
				path = "no file selected";
			}
			((TextView) findViewById(R.id.file_path)).setText(path);
		}
	}
}