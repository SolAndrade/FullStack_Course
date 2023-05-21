package midterm.JavaSpringServiceLayer;

@Service
public class PrescriptionService {
 
    DoctorRepository doctorRepository;
    DrugRepository drugRepository;

    @Autowired
    public PrescriptionService(DoctorRepository doctorRepository, DrugRepository drugRepository) {
        this.doctorRepository = doctorRepository;
        this.drugRepository = drugRepository;
    }
  
    public PrescriptionOrderForm fillOrder(Order order){
        Doctor doctor = doctorRepository.findById(order.getDoctorId()).orElse(null);
        Drug drug = drugRepository.findById(order.getDrugId()).orElse(null);
        
        if(doctor == null) {
              throw new IllegalArgumentException("Doctor with ID " + order.getDoctorId() + " not found");
        }
      if (drug == null) {
    throw new IllegalArgumentException("Drug with ID " + order.getDrugId() + " not found");
      }
      double dosage = order.getPatientWeight() * drug.getDosageRate();
      
      PrescriptionOrderForm form = new PrescriptionOrderForm();
      form.setPatientName(order.getPatientName());
      form.setDoctorName(doctor.getName());
      form.setDrugName(drug.getName());
      form.setDosage(dosage);
      
      return form;
    }
  
}