import txt_processor

def does_add_to_2020(int1, int2):
  return (int1 + int2) == 2020

def find_2020_ints(comparing_int, int_list):
  i = 1
  while i < len(int_list):
    if does_add_to_2020(comparing_int, int_list[i]):
      print("% s and % s add up to 2020!"%(comparing_int, int_list[i]))
      print("The product of both is % s"%(comparing_int*int_list[i]))
      return
    else:
      i += 1
  next_int = int_list.pop(0)
  return find_2020_ints(next_int, int_list)

def main():
  input_list = txt_processor.get_int_list()
  first_int = input_list.pop(0)
  find_2020_ints(first_int, input_list)

if __name__ == "__main__":
  main()