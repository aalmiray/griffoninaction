/*
 * This script is executed inside the UI thread, so be sure to  call
 * long running code in another thread.
 *
 * You have the following options
 * - execOutsideUI { // your code }
 * - execFuture { // your code }
 * - Thread.start { // your code }
 *
 * You have the following options to run code again inside the UI thread
 * - execInsideUIAsync { // your code }
 * - execInsideUISync { // your code }
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
