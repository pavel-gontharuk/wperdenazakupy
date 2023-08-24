package com.gontharuk.wperdenazakupy.model.product.data

import com.gontharuk.wperdenazakupy.model.core.mapstore.MapStore
import com.gontharuk.wperdenazakupy.model.core.mapstore.ReadStrategy
import com.gontharuk.wperdenazakupy.model.core.mapstore.WriteStrategy
import com.gontharuk.wperdenazakupy.model.product.entity.Product

object ProductStore : MapStore<String, Product>()