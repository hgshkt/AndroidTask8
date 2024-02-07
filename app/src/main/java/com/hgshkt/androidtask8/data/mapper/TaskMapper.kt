package com.hgshkt.androidtask8.data.mapper

import com.hgshkt.androidtask8.data.db.model.TaskDB
import com.hgshkt.androidtask8.view.model.TaskDisplay

fun TaskDisplay.toDB(): TaskDB = TaskDB(
    id = id,
    description = description
)

fun TaskDB.toDisplay(): TaskDisplay = TaskDisplay(
    id = id,
    description = description
)