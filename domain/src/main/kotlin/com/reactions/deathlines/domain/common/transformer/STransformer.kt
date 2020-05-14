package com.reactions.deathlines.domain.common.transformer

import io.reactivex.SingleTransformer

/**
 * A transformer to io thread for singles.
 */
abstract class STransformer<T> : SingleTransformer<T, T>