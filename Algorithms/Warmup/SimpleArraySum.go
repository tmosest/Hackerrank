package main
import "fmt"

func main() {
    var n int
    fmt.Scanf("%v", &n)
    sum := 0
    arr := make([]int, n)
    for i := range arr {
      fmt.Scanf("%v", &arr[i])
      sum += arr[i]
    }
    fmt.Println(sum)
}
