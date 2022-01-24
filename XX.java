package org.apache.spark.sql.execution;

import org.apache.spark.sql.catalyst.InternalRow;

public Object generate(Object[] references) {
        return new GeneratedIteratorForCodegenStage2(references);
}

/*wsc_codegenStageId*/
final class GeneratedIteratorForCodegenStage2 extends org.apache.spark.sql.execution.BufferedRowIterator {
    private Object[] references;
    private scala.collection.Iterator[] inputs;
    private boolean agg_initAgg_0;
    private boolean agg_bufIsNull_0;
    private double agg_bufValue_0;
    private scala.collection.Iterator inputadapter_input_0;
    private boolean agg_agg_isNull_3_0;
    private boolean agg_agg_isNull_5_0;
    private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter[] agg_mutableStateArray_0 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter[1];

    public GeneratedIteratorForCodegenStage2(Object[] references) {
        this.references = references;
    }

    public void init(int index, scala.collection.Iterator[] inputs) {
        partitionIndex = index;
        this.inputs = inputs;

        inputadapter_input_0 = inputs[0]; //this should be an Iterator to InternalRow
        agg_mutableStateArray_0[0] = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(1, 0);

    }

    private void agg_doAggregateWithoutKey_0() throws java.io.IOException {
// initialize aggregation buffer
        agg_bufIsNull_0 = true;
        agg_bufValue_0 = -1.0;

        while ( inputadapter_input_0.hasNext()) {
            InternalRow inputadapter_row_0 = (InternalRow) inputadapter_input_0.next();

            boolean inputadapter_isNull_0 = inputadapter_row_0.isNullAt(0);
            double inputadapter_value_0 = inputadapter_isNull_0 ?
                    -1.0 : (inputadapter_row_0.getDouble(0));

            agg_doConsume_0(inputadapter_row_0, inputadapter_value_0, inputadapter_isNull_0);
// shouldStop check is eliminated
        }

    }

    private void agg_doConsume_0(InternalRow inputadapter_row_0, double agg_expr_0_0, boolean agg_exprIsNull_0_0) throws java.io.IOException {
// do aggregate
// common sub-expressions

// evaluate aggregate functions and update aggregation buffers

        agg_agg_isNull_3_0 = true;
        double agg_value_3 = -1.0;
        do {
            boolean agg_isNull_4 = true;
            double agg_value_4 = -1.0;
            agg_agg_isNull_5_0 = true;
            double agg_value_5 = -1.0;
            do {
                if (!agg_bufIsNull_0) {
                    agg_agg_isNull_5_0 = false;
                    agg_value_5 = agg_bufValue_0;
                    continue;
                }

                if (!false) {
                    agg_agg_isNull_5_0 = false;
                    agg_value_5 = 0.0D;
                    continue;
                }

            } while (false);

            if (!agg_exprIsNull_0_0) {
                agg_isNull_4 = false; // resultCode could change nullability.

                agg_value_4 = agg_value_5 + agg_expr_0_0;

            }
            if (!agg_isNull_4) {
                agg_agg_isNull_3_0 = false;
                agg_value_3 = agg_value_4;
                continue;
            }

            if (!agg_bufIsNull_0) {
                agg_agg_isNull_3_0 = false;
                agg_value_3 = agg_bufValue_0;
                continue;
            }

        } while (false);

        agg_bufIsNull_0 = agg_agg_isNull_3_0;
        agg_bufValue_0 = agg_value_3;

    }

    protected void processNext() throws java.io.IOException {
        while (!agg_initAgg_0) {
            agg_initAgg_0 = true;
            long agg_beforeAgg_0 = System.nanoTime();
            agg_doAggregateWithoutKey_0();
            ((org.apache.spark.sql.execution.metric.SQLMetric) references[1] /* aggTime */).add((System.nanoTime() - agg_beforeAgg_0) / 1000000);

// output the result

            ((org.apache.spark.sql.execution.metric.SQLMetric) references[0] /* numOutputRows */).add(1);
            agg_mutableStateArray_0[0].reset();

            agg_mutableStateArray_0[0].zeroOutNullBytes();

            if (agg_bufIsNull_0) {
                agg_mutableStateArray_0[0].setNullAt(0);
            } else {
                agg_mutableStateArray_0[0].write(0, agg_bufValue_0);
            }
            append((agg_mutableStateArray_0[0].getRow()));
        }
    }

};

public Object1 generate(Object[] references) {
    return new GeneratedIteratorForCodegenStage1(references);
}

/*wsc_codegenStageId*/
final class GeneratedIteratorForCodegenStage1 extends org.apache.spark.sql.execution.BufferedRowIterator {
    private Object[] references;
    private scala.collection.Iterator[] inputs;
    private boolean agg_initAgg_0;
    private boolean agg_bufIsNull_0;
    private double agg_bufValue_0;
    private scala.collection.Iterator inputadapter_input_0;
    private boolean agg_agg_isNull_3_0;
    private boolean agg_agg_isNull_5_0;
    private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter[] filter_mutableStateArray_0 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter[4];

    public GeneratedIteratorForCodegenStage1(Object[] references) {
        this.references = references;
    }

    public void init(int index, scala.collection.Iterator[] inputs) {
        partitionIndex = index;
        this.inputs = inputs;

        inputadapter_input_0 = inputs[0];
        filter_mutableStateArray_0[0] = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(4, 0);
        filter_mutableStateArray_0[1] = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(2, 0);
        filter_mutableStateArray_0[2] = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(2, 0);
        filter_mutableStateArray_0[3] = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(1, 0);

    }

    private void agg_doAggregate_sum_0(boolean agg_exprIsNull_0_0, boolean agg_exprIsNull_1_0, double agg_expr_0_0, double agg_expr_1_0) throws java.io.IOException {
        agg_agg_isNull_3_0 = true;
        double agg_value_3 = -1.0;
        do {
            boolean agg_isNull_4 = true;
            double agg_value_4 = -1.0;
            agg_agg_isNull_5_0 = true;
            double agg_value_5 = -1.0;
            do {
                if (!agg_bufIsNull_0) {
                    agg_agg_isNull_5_0 = false;
                    agg_value_5 = agg_bufValue_0;
                    continue;
                }

                if (!false) {
                    agg_agg_isNull_5_0 = false;
                    agg_value_5 = 0.0D;
                    continue;
                }

            } while (false);
            boolean agg_isNull_8 = true;
            double agg_value_8 = -1.0;

            if (!agg_exprIsNull_0_0) {
                if (!agg_exprIsNull_1_0) {
                    agg_isNull_8 = false; // resultCode could change nullability.

                    agg_value_8 = agg_expr_0_0 * agg_expr_1_0;

                }

            }
            if (!agg_isNull_8) {
                agg_isNull_4 = false; // resultCode could change nullability.

                agg_value_4 = agg_value_5 + agg_value_8;

            }
            if (!agg_isNull_4) {
                agg_agg_isNull_3_0 = false;
                agg_value_3 = agg_value_4;
                continue;
            }

            if (!agg_bufIsNull_0) {
                agg_agg_isNull_3_0 = false;
                agg_value_3 = agg_bufValue_0;
                continue;
            }

        } while (false);

        agg_bufIsNull_0 = agg_agg_isNull_3_0;
        agg_bufValue_0 = agg_value_3;
    }

    private void agg_doAggregateWithoutKey_0() throws java.io.IOException {
// initialize aggregation buffer
        agg_bufIsNull_0 = true;
        agg_bufValue_0 = -1.0;

        while ( inputadapter_input_0.hasNext()) {
            InternalRow inputadapter_row_0 = (InternalRow) inputadapter_input_0.next();

            do {
                boolean inputadapter_isNull_3 = inputadapter_row_0.isNullAt(3);
                int inputadapter_value_3 = inputadapter_isNull_3 ?
                        -1 : (inputadapter_row_0.getInt(3));

                boolean filter_value_2 = !inputadapter_isNull_3;
                if (!filter_value_2) continue;

                boolean filter_value_3 = false;
                filter_value_3 = inputadapter_value_3 >= 8766;
                if (!filter_value_3) continue;
                boolean filter_value_8 = !inputadapter_isNull_3;
                if (!filter_value_8) continue;

                boolean filter_value_9 = false;
                filter_value_9 = inputadapter_value_3 < 9131;
                if (!filter_value_9) continue;
                boolean inputadapter_isNull_0 = inputadapter_row_0.isNullAt(0);
                double inputadapter_value_0 = inputadapter_isNull_0 ?
                        -1.0 : (inputadapter_row_0.getDouble(0));

                boolean filter_value_14 = !inputadapter_isNull_0;
                if (!filter_value_14) continue;

                boolean filter_value_15 = false;
                filter_value_15 = org.apache.spark.sql.catalyst.util.SQLOrderingUtil.compareDoubles(inputadapter_value_0, 0.05D) >= 0;
                if (!filter_value_15) continue;
                boolean filter_value_20 = !inputadapter_isNull_0;
                if (!filter_value_20) continue;

                boolean filter_value_21 = false;
                filter_value_21 = org.apache.spark.sql.catalyst.util.SQLOrderingUtil.compareDoubles(inputadapter_value_0, 0.07D) <= 0;
                if (!filter_value_21) continue;
                boolean inputadapter_isNull_2 = inputadapter_row_0.isNullAt(2);
                double inputadapter_value_2 = inputadapter_isNull_2 ?
                        -1.0 : (inputadapter_row_0.getDouble(2));

                boolean filter_value_26 = !inputadapter_isNull_2;
                if (!filter_value_26) continue;

                boolean filter_value_27 = false;
                filter_value_27 = org.apache.spark.sql.catalyst.util.SQLOrderingUtil.compareDoubles(inputadapter_value_2, 24.0D) < 0;
                if (!filter_value_27) continue;

                ((org.apache.spark.sql.execution.metric.SQLMetric) references[0] /* numOutputRows */).add(1);

// common sub-expressions

                boolean inputadapter_isNull_1 = inputadapter_row_0.isNullAt(1);
                double inputadapter_value_1 = inputadapter_isNull_1 ?
                        -1.0 : (inputadapter_row_0.getDouble(1));

                agg_doConsume_0(inputadapter_value_1, inputadapter_isNull_1, inputadapter_value_0, false);

            } while(false);
// shouldStop check is eliminated
        }

    }

    private void agg_doConsume_0(double agg_expr_0_0, boolean agg_exprIsNull_0_0, double agg_expr_1_0, boolean agg_exprIsNull_1_0) throws java.io.IOException {
// do aggregate
// common sub-expressions

// evaluate aggregate functions and update aggregation buffers
        agg_doAggregate_sum_0(agg_exprIsNull_0_0, agg_exprIsNull_1_0, agg_expr_0_0, agg_expr_1_0);

    }

    protected void processNext() throws java.io.IOException {
        while (!agg_initAgg_0) {
            agg_initAgg_0 = true;
            long agg_beforeAgg_0 = System.nanoTime();
            agg_doAggregateWithoutKey_0();
            ((org.apache.spark.sql.execution.metric.SQLMetric) references[2] /* aggTime */).add((System.nanoTime() - agg_beforeAgg_0) / 1000000);

// output the result

            ((org.apache.spark.sql.execution.metric.SQLMetric) references[1] /* numOutputRows */).add(1);
            filter_mutableStateArray_0[3].reset();

            filter_mutableStateArray_0[3].zeroOutNullBytes();

            if (agg_bufIsNull_0) {
                filter_mutableStateArray_0[3].setNullAt(0);
            } else {
                filter_mutableStateArray_0[3].write(0, agg_bufValue_0);
            }
            append((filter_mutableStateArray_0[3].getRow()));
        }
    }

};