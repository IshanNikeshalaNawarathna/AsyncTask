# AsyncTask Android Project

This project demonstrates the use of **AsyncTask** in Android for performing background tasks while updating the UI. This class was deprecated in API level 30.

## Features

- Perform background operations efficiently.
- Update the UI with progress and results.
- Avoid blocking the main thread.

## Overview of AsyncTask

**AsyncTask** is a mechanism in Android for performing operations in the background. It provides a simple interface for:

- `doInBackground()`: Executes the long-running background task.
- `onProgressUpdate()`: Updates the UI with intermediate progress.
- `onPostExecute()`: Updates the UI with the result of the task.

## AsyncTask's generic types
The three types used by an asynchronous task are the following:

- `Params`, the type of the parameters sent to the task upon execution.
- `Progress`, the type of the progress units published during the background computation.
- `Result`, the type of the result of the background computation.

![image](https://github.com/user-attachments/assets/4d35c591-1cec-4355-b85e-86bab9f27316)

## Code Snippet

```java
private class MyAsyncTask extends AsyncTask<Void, Integer, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Initialize UI components here
    }

    @Override
    protected String doInBackground(Void... voids) {
        for (int i = 0; i <= 100; i++) {
            publishProgress(i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Task Completed!";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        // Update progress bar or UI element with values[0]
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // Display result on the UI
    }
}
```

 ---
Happy coding! 🎉

