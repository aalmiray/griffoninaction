/*
 * This script is executed inside the EDT, so be sure to
 * call long running code in another thread.
 *
 * You have the following options
 * - SwingBuilder.doOutside { // your code  }
 * - Thread.start { // your code }
 * - SwingXBuilder.withWorker( start: true ) {
 *      onInit { // initialization (optional, runs in current thread) }
 *      work { // your code }
 *      onDone { // finish (runs inside EDT) }
 *   }
 *
 * You have the following options to run code again inside EDT
 * - SwingBuilder.doLater { // your code }
 * - SwingBuilder.edt { // your code }
 * - SwingUtilities.invokeLater { // your code }
 */

def v = app.views.ThreadingFileViewer

[ [testLabel: "No threading", action: "readFileNoThreading"],
   [testLabel: "Threading - doOutside/doLater", action: "readFileWithThreading"],
   [testLabel: "Threading - withWorker", action: "readFileWithWorker"],
   [testLabel: "Threading - progress update", action: "readFileWithUpdates"] ].eachWithIndex { entry, i ->
      v.createMVCGroup("ReadingTab", "tab"+i,
         [tabGroup: v.tabGroup, index: i+1,
          mainWindow: v.fileViewerWindow,
          fileChooser: v.fileChooserWindow] + entry)
}
