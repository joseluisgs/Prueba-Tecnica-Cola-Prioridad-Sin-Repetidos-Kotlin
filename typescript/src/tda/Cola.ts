interface Cola<T> {
  push: (item: T) => void
  pop: () => T | undefined
  isEmpty: () => boolean
}

export default Cola
