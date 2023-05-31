export const formatToKm = (number) => 
  new Intl.NumberFormat('pt-BR', { style: 'unit', unit: 'kilometer' }).format(number)