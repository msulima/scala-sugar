package com.futureprocessing.scala_sugar.files_structure

import java.util

trait IListCreator {
    def createNewEmptyList(): util.List[Any]
}

private[scala_sugar] class SecretListCreatorImpl extends IListCreator {

    import com.google.common.collect.Lists
    import Lists.{newArrayList => newList}

    def createNewEmptyList() = newList()
}