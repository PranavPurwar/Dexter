package ma.dexter.editor.util

import android.view.View
import android.view.inputmethod.EditorInfo
import io.github.rosemoe.sora.widget.CodeEditor

fun CodeEditor.setDefaults() {
    isOverScrollEnabled = false
    inputType =
        EditorInfo.TYPE_TEXT_FLAG_NO_SUGGESTIONS or EditorInfo.TYPE_CLASS_TEXT or EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE or EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
    importantForAutofill = View.IMPORTANT_FOR_AUTOFILL_NO

    setTextSize(16f)
}

fun CodeEditor.setOnTextChangedListener(
    listener: () -> Unit
) {
    setSingleEventListener(object : SingleEditorEventListener() {
        override fun onNewTextSet(editor: CodeEditor) {
            listener()
        }

        override fun afterDelete(
            editor: CodeEditor, content: CharSequence,
            startLine: Int, startColumn: Int,
            endLine: Int, endColumn: Int, deletedContent: CharSequence?
        ) {
            listener()
        }

        override fun afterInsert(
            editor: CodeEditor, content: CharSequence,
            startLine: Int, startColumn: Int,
            endLine: Int, endColumn: Int, insertedContent: CharSequence?
        ) {
            listener()
        }
    })
}

fun CodeEditor.setSingleEventListener(
    listener: SingleEditorEventListener
) {
    setEventListener(listener)
}